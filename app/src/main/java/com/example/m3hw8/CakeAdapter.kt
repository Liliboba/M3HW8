import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m3hw8.CakeModel
import com.example.m3hw8.databinding.ItemCakeBinding

class CakeAdapter(
    private val cakes: List<CakeModel>,
    private val onItemClick: ()-> Unit
) : RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {

    class CakeViewHolder(private val binding: ItemCakeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cake: CakeModel, onItemClick: () -> Unit) {
            binding.tvTitle.text = cake.name
            binding.tvDescription.text = cake.cost

            binding.root.setOnClickListener{onItemClick()}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val binding = ItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.bind(cakes[position], onItemClick)
    }

    override fun getItemCount(): Int = cakes.size
}