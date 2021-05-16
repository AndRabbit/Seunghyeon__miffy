package org.sopt.presentation.home.userinfo.following

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.data.FollowingUserInfo
import org.sopt.databinding.ItemFollowUserBinding

// 1. Adapter는 RecyclerView.Adapter를 상속받습니다.
// <ViewHolder> 부분으로 해당 어댑터가 어떤 ViewHolder로 변경하는지 알려줍니다.
class FollowingListAdapter: RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {

    // 2. Adapter는 ViewHolder로 변경할 Data를 가지고 있어야합니다.
    val userList = mutableListOf<FollowingUserInfo>()

    // 3. Adapter는 아이템마다 ViewHolder를 만드는 방법을 정의해야합니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding = ItemFollowUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FollowingUserViewHolder(binding)
    }

    // 4. Adapter는 전체 아이템의 수를 알아야합니다.
    override fun getItemCount(): Int = userList.size

    // 5. Adapter는 ViewHolder에 Data를 전달하는 방법을 정의해야합니다.
    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    class FollowingUserViewHolder(
        private val binding: ItemFollowUserBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo){
            binding.tvFollowUserName.text = followingUserInfo.userName
        }
    }
}