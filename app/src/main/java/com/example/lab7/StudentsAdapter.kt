package layout

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab7.R
import com.example.lab7.ViewHolder
import kotlinx.android.synthetic.main.std_item_layout.view.*

class StudentsAdapter (val item:List<Student>,val context : Context):RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout,parent,false)
        return ViewHolder(view_item)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvID.text="ID : "+item[position].id
        holder.tvName.text="Name : "+item[position].name
        holder.tvAge.text="Age : "+item[position].age.toString()
    }

    override fun getItemCount(): Int {
        return item.size
    }


}

