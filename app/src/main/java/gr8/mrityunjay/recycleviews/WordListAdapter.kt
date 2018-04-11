package gr8.mrityunjay.recycleviews

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.wordlist_item.view.*
import java.util.*

class WordListAdapter(): RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private lateinit var mWordList: LinkedList<String>
    private lateinit var mInflater: LayoutInflater

    class WordViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        lateinit var wordItemView: TextView
        private lateinit var mAdapter: WordListAdapter

        constructor(v: View, adapter: WordListAdapter) : this(v){
            this.wordItemView = v.word
            this.mAdapter = adapter
            wordItemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            wordItemView.text = "Clicked! ${wordItemView.text}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView: View = mInflater.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(mItemView, this)
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        val mCurrent = mWordList[position]
        holder.wordItemView.text = mCurrent
    }

    constructor(context: Context, wordList: LinkedList<String>): this(){
        mInflater = LayoutInflater.from(context)
        this.mWordList = wordList
    }
}