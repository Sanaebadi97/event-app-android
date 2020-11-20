package co.eventbox.tedxtehran.view.news

import android.content.Context
import android.util.Log
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.listener.NewsOnClickListener
import co.eventbox.tedxtehran.utilities.load
import co.eventbox.tedxtehran.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_news.view.*
import kotlinx.android.synthetic.main.row_news.view.txtTitle

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class NewsAdapter(var listener: NewsOnClickListener) : AdapterRecyclerView<DashboardCacheQuery.New>(
    R.layout.row_news,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {


    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.New?
    ) {
        val itemView = viewHolder.itemView


        itemView.txtTitle.text = element?.title()
        itemView.txtDesc.text = element?.description()
        itemView.imgLogo.load(element?.iconUrl().toImageURL(), R.drawable.placeholdertransparent)

        itemView.cardView.setOnClickListener {
            this.listener.onSelected(position, element?.extraLink().toString())
        }
    }


}