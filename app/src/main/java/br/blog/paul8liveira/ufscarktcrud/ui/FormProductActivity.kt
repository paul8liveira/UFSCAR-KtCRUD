package br.blog.paul8liveira.ufscarktcrud.ui.activity

import br.blog.paul8liveira.ufscarktcrud.R
import br.blog.paul8liveira.ufscarktcrud.dao.ProductDao
import br.blog.paul8liveira.ufscarktcrud.model.Product
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form_product.*

class FormProductActivity : AppCompatActivity() {

    private val productDao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_product)
        configureSaveButton()
    }

    private fun configureSaveButton() {
        form_product_save_button.setOnClickListener {
            saveProduct()
            finish()
        }
    }

    private fun saveProduct() {
        val createdProduct = create()
        productDao.add(createdProduct)
    }

    private fun create(): Product {
        val name = form_product_name.editText?.text.toString()
        val description = form_product_description.editText?.text.toString()
        val quantity = form_product_quantity.editText?.text.toString().toInt()
        return Product(name = name, description = description, quantity = quantity)
    }
}
