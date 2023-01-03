package uns.pmf.learningandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import uns.pmf.learningandroid.databinding.ListItemBinding

class MyRecyclerViewAdapter(private val fruits: List<String>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root) {
        val listItemBinding: ListItemBinding

        init {
            this.listItemBinding = listItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val listItemBinding: ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = fruits[position]
        holder.listItemBinding.name = name
    }

    override fun getItemCount(): Int {
        return fruits.size
    }
}