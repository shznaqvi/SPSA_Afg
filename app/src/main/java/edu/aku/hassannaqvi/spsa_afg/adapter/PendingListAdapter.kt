package edu.aku.hassannaqvi.spsa_afg.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import edu.aku.hassannaqvi.spsa_afg.R
import edu.aku.hassannaqvi.spsa_afg.databinding.PendingformLayoutBinding
import edu.aku.hassannaqvi.spsa_afg.models.Form

class PendingListAdapter(private val mContext: Context, private var mList: List<Form>) : RecyclerView.Adapter<PendingListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val bi: PendingformLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.forms_list_item, viewGroup, false)
        return ViewHolder(bi)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.bi.parentLayout.tag = i
        holder.bi.cluster.text = "CLUSTER: ".plus(mList[i].pid)
        holder.bi.hhno.text = "HHNO: ".plus(mList[i].s1q1)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setMList(members: List<Form>) {
        mList = members
        notifyDataSetChanged()
    }

    class ViewHolder(val bi: PendingformLayoutBinding) : RecyclerView.ViewHolder(bi.root)

}