package com.example.iyeongjun.soptoop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Recyclerview는 안드로이드 프레임워크에 관한 내용으로
 * OOP 세미나 입장에서는 문제가 있지만, 예제에 포함된 내용인만큼
 * 이해하는데 필요하다 생각해서 주석을 남김
 * RecyclerView는 List뷰의 상위호환버전으로,
 * 초기에 화면에 보이는 만큼만 onCreateViewHolder에서 만들어짐 (예 : 데이터가 10만개여도 화면크기가 작아
 * 10개까지 밖에 보이지 않으면 10개만 만듬 (onCreateViewHolder))
 * 그리고 스크롤할떄마다 새롭게 노출되는 layout은 하단스크롤시 화면에서 사라진 최상단 뷰를 가져와
 * 데이터만 바꿔줌(onBIndViewHolder)
 */
class RecyclerAdapter( item : ArrayList<String> ) : RecyclerView.Adapter<ViewHolder>() {
    val item = item

    //onCreateViewHolder는 최초에 보여주는 뷰를 만들어짐(일회성 호출)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item , parent, false)
        return ViewHolder(view)
    }

    //getItemCount는 보여질 최대 뷰의 갯수
    override fun getItemCount(): Int {
        return item.size
    }

    // onBindViewHolder는 화면에 뷰를 보여줄떄마다 호출. 최초 로딩시에 onCreateViewHolder로 만들어진
    // 뷰에 데이터를 껴넣고(즉 onCreateViewHolder만큼 최초의 호출됨), 이후 스크롤할떄마다 새로운 뷰가 보이면
    // 그 뷰에 데이터를 끼어넣는 역할을 함
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.txtRecycler.text = item[position]
    }

}
// 최초의 화면에 보여지는 뷰의 홀더임. 이 홀더라는 개념은 데이터는 넣어지지 않은,
// 그냥 순수하게 프로토타이핑 된 뷰만을 뜻함.
class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var txtRecycler = itemView.findViewById<TextView>(R.id.txtRecycler)
}