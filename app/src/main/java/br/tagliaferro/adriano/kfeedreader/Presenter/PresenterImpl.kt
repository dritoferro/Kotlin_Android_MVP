package br.tagliaferro.adriano.kfeedreader.Presenter

import android.content.Context
import br.tagliaferro.adriano.kfeedreader.Model.DTO.Item
import br.tagliaferro.adriano.kfeedreader.View.ViewImpl

interface PresenterImpl {

    fun loadRss()

    fun getContext(): Context

    fun loadAdapter(list: ArrayList<Item>)

    fun setView(view: ViewImpl)
}