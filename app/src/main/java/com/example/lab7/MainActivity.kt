package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import layout.Student
import layout.StudentsAdapter

class MainActivity : AppCompatActivity() {

    val studentList= arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
recycler_view.layoutManager = LinearLayoutManager (applicationContext)    }
    fun studentData(){
      studentList.add(Student("60215659869","lol",20))
        studentList.add(Student("6398569985","ga",58))
    }


    fun addStudent(view: View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val myBinder = AlertDialog.Builder(this)
        myBinder.setView(mDialogView)
        val mAlertDialog = myBinder.show()
        mAlertDialog.btnAdd.setOnClickListener {
            studentList.add(
                Student(
                    mAlertDialog.edt_id.text.toString(),
                    mAlertDialog.edt_name.text.toString(),
                    mAlertDialog.edt_age.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The student is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.dismiss()
        }
        mAlertDialog.btnCancel.setOnClickListener {
            mAlertDialog.dismiss()
        }

}




}