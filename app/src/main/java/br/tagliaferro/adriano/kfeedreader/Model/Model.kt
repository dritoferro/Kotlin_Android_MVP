package br.tagliaferro.adriano.kfeedreader.Model

import br.tagliaferro.adriano.kfeedreader.Model.DTO.Item
import br.tagliaferro.adriano.kfeedreader.Presenter.Presenter
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS

class Model(private val presenter: Presenter) : ModelImpl, Callback {

    private val listItens = arrayListOf<Item>()

    override fun loadRss() {
        try {
            PkRSS.with(presenter.getContext()).load("https://rss.tecmundo.com.br/feed").callback(this).async()
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }

    override fun onPreload() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoaded(newArticles: MutableList<Article>?) {

        try {
            listItens.clear()
            newArticles?.mapTo(listItens) {
                Item(it.title, it.author, it.date, it.source, it.enclosure.url)
            }

            presenter.loadAdapter(listItens)
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }

    override fun onLoadFailed() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}