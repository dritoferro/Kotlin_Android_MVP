package br.tagliaferro.adriano.kfeedreader.Model.DTO

import android.net.Uri

data class Item(val title: String, val author: String, val date: Long, val link: Uri, val image: String)