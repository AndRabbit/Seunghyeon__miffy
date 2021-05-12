package org.sopt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.databinding.ItemRepositoryBinding

// 1. Adapter는 RecyclerView.Adapter를 상속받는다
// <ViewHolder> 부분으로 해당 어댑터가 어떤 ViewHolder로 변경하는지 알려준다
class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    // 2. Adapter는 ViewHolder로 변경할 Data를 가지고 있어야 한
    val repoList = mutableListOf<RepositoryInfo>()

    // 3. Adapter는 아이템마다 ViewHolder를 만드는 방법을 정의해야 한다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepositoryViewHolder(binding)
    }

    // 4. Adapter는 전체 아이템의 수를 알아야 한다
    override fun getItemCount(): Int = repoList.size

    // 5. Adapter는 ViewHolder에 Data를 전달하는 방법을 정의해아한다
    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    class RepositoryViewHolder(
        private val binding: ItemRepositoryBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryInfo: RepositoryInfo){
            binding.tvItemRepoName.text=repositoryInfo.repoName
            binding.tvItemRepoInfo.text=repositoryInfo.repoInfo
            binding.tvItemRepoLang.text=repositoryInfo.repoLang
        }
    }
}