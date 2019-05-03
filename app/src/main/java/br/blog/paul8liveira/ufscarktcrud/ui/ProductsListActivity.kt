package br.blog.paul8liveira.ufscarktcrud.ui.activity

import br.blog.paul8liveira.ufscarktcrud.R
import br.blog.paul8liveira.ufscarktcrud.dao.ProductDao
import br.blog.paul8liveira.ufscarktcrud.ui.activity.recyclerview.ProductsListAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_products_list.*

class ProductsListActivity : AppCompatActivity() {

    private val productDao = ProductDao()
    private lateinit var adapter: ProductsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        configureRecyclerView()
        configureFabAddProduct()
    }

    private fun configureFabAddProduct() {
        product_list_add_product.setOnClickListener {
            val openProductForm = Intent(this, FormProductActivity::class.java)
            startActivity(openProductForm)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.replaceAllProducts(productDao.all())
    }

    private fun configureRecyclerView() {
        this.adapter = ProductsListAdapter(context = this)
        products_list_recyclerview.adapter = adapter
    }

}
