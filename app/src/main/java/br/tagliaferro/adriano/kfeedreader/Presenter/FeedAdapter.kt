package br.tagliaferro.adriano.kfeedreader.Presenter

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.tagliaferro.adriano.kfeedreader.Model.DTO.Item
import br.tagliaferro.adriano.kfeedreader.R
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

class ItemAdapter(val list: ArrayList<Item>, val presenter: Presenter) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtTitle = view.findViewById(R.id.cardTextTitle) as TextView
        val txtAuthor = view.findViewById(R.id.cardTextAuthor) as TextView
        val txtData = view.findViewById(R.id.cardTextDate) as TextView
        val Image = view.findViewById(R.id.cardImage) as ImageView
        val btnSeeMore = view.findViewById(R.id.cardBtnVMais) as Button


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_list, p0, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0?.txtTitle?.text = list[p1].title
        p0?.txtAuthor?.text = list[p1].author
        p0?.txtData?.text = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(Date(list[p1].date))
        p0?.btnSeeMore.setOnClickListener { createIntent(list[p1].link) }
        Glide.with(p0.itemView).load(list[p1].image).into(p0?.Image)

    }

    override fun getItemCount(): Int = list.size

    private fun createIntent(url: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, url)
        presenter.getContext().startActivity(intent)
    }

}