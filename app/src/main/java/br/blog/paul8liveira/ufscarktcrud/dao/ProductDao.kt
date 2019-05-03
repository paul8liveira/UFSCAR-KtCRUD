package br.blog.paul8liveira.ufscarktcrud.dao

import br.blog.paul8liveira.ufscarktcrud.model.Product

class ProductDao {

    companion object {
        private val products: MutableList<Product> = mutableListOf()
    }

    fun all (): List<Product> {
        return products
    }

    fun add(vararg product: Product){
        products.addAll(product)
    }

}
