package com.example.newsapikotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapikotlin.R
import com.example.newsapikotlin.model.Article
import com.example.newsapikotlin.tosimpleString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_article_list.view.*

class ArticleListAdapter(var artivcallist: List<Article> = ArrayList()) :
    RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {
    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener=clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_article_list, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return artivcallist.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindArticle(artivcallist.get(position))
    }

    //for update list
    fun updateList(article: List<Article>) {
        this.artivcallist = article
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var view: View = itemView
        private lateinit var article: Article
        init {
            //this=viewholder
            itemView.setOnClickListener(this)
        }
        fun bindArticle(article: Article) {
            this.article = article
            Picasso.get()
                .load(article.urlToimage)
                .placeholder(R.drawable.download)
                .into(view.articleImage)
            view.articleTitle.text = article.title
            view.articleDescription.text = article.descriptor
            view.articleDate.text = tosimpleString(article.publishedAt)
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(article)
        }
    }

    interface ClickListener {
        fun onClick(article: Article)
    }
}