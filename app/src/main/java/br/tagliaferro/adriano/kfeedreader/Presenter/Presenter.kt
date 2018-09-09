package br.tagliaferro.adriano.kfeedreader.Presenter

import android.content.Context
import br.tagliaferro.adriano.kfeedreader.Model.DTO.Item
import br.tagliaferro.adriano.kfeedreader.Model.Model
import br.tagliaferro.adriano.kfeedreader.View.ViewImpl

class Presenter : PresenterImpl {

    private val model: Model = Model(this)
    private lateinit var view: ViewImpl

    override fun getContext(): Context {
        return view.getContext()
    }


    override fun loadRss() {
        model.loadRss()
    }

    override fun loadAdapter(list: ArrayList<Item>) {
        view.updateAdapter(list)
    }

    override fun setView(view: ViewImpl) {
        this.view = view
    }

}