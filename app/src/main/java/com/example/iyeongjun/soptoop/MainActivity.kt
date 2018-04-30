package com.example.iyeongjun.soptoop

import android.content.ComponentCallbacks
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

// View에 OnClickListener를 상속받았음으로, MainActivity는 OnClickListener로 캐스팅 가능
class MainActivity : AppCompatActivity(), View.OnClickListener {

    // 데이터 생성
    var list : ArrayList<String> = ArrayList()


    override fun onClick(v: View?) {
        // Context는 안드로이드 프레임워크의 최상위 객체임.
        // 메모리 접근, 뷰 노출 등의 함수 및 멤버가 존재
        // MainActivity가 상속하는 AppCompatActivity가 최종적으론 Context를 상속받기때문에
        // this를 넘길 수 있음
        // 즉 this 인 MainActivity가 (Context)MainActivity로 캐스팅 되서 넘겨짐
        // 파라미터가 Context이지만 this를 넘겼음으로 암묵적 업캐스팅되서 넘겨짐
        // RecyclerView.adapter는 Adapter 클래스의 변수임
        // 그럼으로 RecyclerAdapter는 Adapter 클래스를 상속받아야함
        recyclerView.adapter = RecyclerAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 1..100){
            list.add("$i")
        }
        // this인 MainActivity가 OnClickListner를 가지고 있으므로.
        // OnClickListenr가 가진 OnClick 함수와 그 리스트가 참조하고있는
        // ManiActivity의 list가 함께 넘어감
        btnMain.setOnClickListener(this)
    }


}
