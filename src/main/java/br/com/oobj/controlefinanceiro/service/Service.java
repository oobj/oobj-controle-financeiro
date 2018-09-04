package br.com.oobj.controlefinanceiro.service;

import br.com.oobj.controlefinanceiro.service.exception.CreateException;
import br.com.oobj.controlefinanceiro.service.exception.DeleteException;
import br.com.oobj.controlefinanceiro.service.exception.NotFoundException;
import br.com.oobj.controlefinanceiro.service.exception.UpdateException;

public interface Service<E> {
	
	/**
     * create
     *
     * @param bean
     * @return
     * @throws CreateException
     */
    E create(E bean) throws CreateException;

    /**
     * update
     *
     * @param bean
     * @return
     * @throws UpdateException
     */
    E update(E bean) throws UpdateException;

    /**
     * delete
     *
     * @param bean
     * @throws DeleteException
     */
    void delete(E bean) throws DeleteException;

    /**
     * deleteById
     *
     * @param id
     * @throws DeleteException
     */
    void delete(Long id) throws DeleteException;

    /**
     * findById
     *
     * @param id
     * @return
     */
    E findById(Long id) throws NotFoundException;

    /**
     *
     * @return
     */
    Iterable<E> findAll();

}
