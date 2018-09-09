package br.tagliaferro.adriano.kfeedreader.View

import android.content.Context
import br.tagliaferro.adriano.kfeedreader.Model.DTO.Item

interface ViewImpl {

    fun loadRss()

    fun getContext(): Context

    fun updateAdapter(list:ArrayList<Item>)
}