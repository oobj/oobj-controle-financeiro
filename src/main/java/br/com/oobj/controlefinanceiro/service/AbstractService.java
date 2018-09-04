package br.com.oobj.controlefinanceiro.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.oobj.controlefinanceiro.repository.support.BaseRepository;
import br.com.oobj.controlefinanceiro.service.exception.CreateException;
import br.com.oobj.controlefinanceiro.service.exception.DeleteException;
import br.com.oobj.controlefinanceiro.service.exception.NotFoundException;
import br.com.oobj.controlefinanceiro.service.exception.UpdateException;

public abstract class AbstractService<E, R extends BaseRepository<E>> implements Service<E> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);
	
	protected R repository;
	

	@Override
    @Transactional
    public E create(E bean) throws CreateException {
        try {
            beforeCreate(bean);
            LOGGER.trace("creating bean...");
            LOGGER.debug("creating entity: {}", bean.toString());
            E saveBean = getRepository().save(bean);
            LOGGER.debug("creating entity: {} ok!", bean.toString());
            LOGGER.trace("creating bean ok!");

            afterCreate(saveBean);
            return bean;

        } catch (CreateException ex) {
        	throw ex;
        } catch (Exception ex) {
            throw new CreateException(ex);
        }
    }
	
	protected void beforeCreate(E bean) throws CreateException {
    	
    }

    protected void afterCreate(E bean) throws CreateException {
    	
    }
    
    @Override
    @Transactional
    public E update(E bean) throws UpdateException {
        try {
            beforeUpdate(bean);
            LOGGER.trace("updating bean...");
            LOGGER.debug("updating entity: {}", bean.toString());
            E updateBean = getRepository().save(bean);
            LOGGER.debug("updating entity: {} ok!", bean.toString());
            LOGGER.trace("updating bean ok!");

            afterUpdate(updateBean);
            return updateBean;

        } catch (UpdateException ex) {
        	throw ex;            
        } catch (Exception ex) {
            throw new UpdateException(ex);
        }
    }

    protected void beforeUpdate(E bean) throws UpdateException { 
    	
    }

    protected void afterUpdate(E bean) throws UpdateException { 
    	
    }


    @Override
    @Transactional
    public void delete(Long id) throws DeleteException {
        try {
            delete(findById(id));
        } catch (NotFoundException e) {
            throw new DeleteException(e);
        }
    }

    @Override
    @Transactional
    public void delete(E bean) throws DeleteException {
        try {
            LOGGER.debug("deleting entity: {}", bean.toString());
            beforeDelete(bean);

            repository.delete(bean);

            afterDelete(bean);
            LOGGER.debug("deleting entity: {} ok!", bean.toString());
            LOGGER.trace("deleting bean ok!");

        } catch (DeleteException ex) {
        	throw ex;            
        } catch (Exception ex) {
            throw new DeleteException(ex);
        }
    }

    protected void beforeDelete(E bean) throws DeleteException {
    	
    }

    protected void afterDelete(E bean) throws DeleteException { 
    	
    }

    @Override
    @Transactional(readOnly = true)
    public E findById(Long id) throws NotFoundException {
    	Optional<E> current = this.repository.findById(id);
		if (!current.isPresent()) {
			throw new NotFoundException();
		}
		return current.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return this.repository.findAll();
    }

    protected R getRepository() {
        return repository;
    }
}
