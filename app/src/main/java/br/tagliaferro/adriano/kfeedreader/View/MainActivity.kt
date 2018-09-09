package br.tagliaferro.adriano.kfeedreader.View

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.tagliaferro.adriano.kfeedreader.Model.DTO.Item
import br.tagliaferro.adriano.kfeedreader.Presenter.ItemAdapter
import br.tagliaferro.adriano.kfeedreader.Presenter.Presenter
import br.tagliaferro.adriano.kfeedreader.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewImpl {

    private lateinit var presenter: Presenter
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter()

    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
        rVFeeds.layoutManager = LinearLayoutManager(this)
        loadRss()
    }

    override fun loadRss() {
        presenter.loadRss()
    }

    override fun getContext(): Context {
        return this
    }

    override fun updateAdapter(list: ArrayList<Item>) {
        adapter = ItemAdapter(list, presenter)
        rVFeeds.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
