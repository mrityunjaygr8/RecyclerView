package gr8.mrityunjay.recycleviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mWordList:LinkedList<String> = LinkedList()
    private var mCount = 0

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: WordListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..20){
            mWordList.addLast("Word$i")
            Log.d("WordList", mWordList.last)
        }

        mRecyclerView = recycler_view
        mAdapter = WordListAdapter(this, mWordList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)


        val fab: FloatingActionButton = fab
        fab.setOnClickListener {
            val wordListSize = mWordList.size
            mWordList.addLast("New Word $wordListSize")
            mRecyclerView.adapter.notifyItemInserted(wordListSize)
            mRecyclerView.smoothScrollToPosition(wordListSize)

        }
    }
}
