package com.example.anwesa_pc.samplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<StudentPojo> studentPojos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemsToArrayList();
        //recyclerview object creation
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        //layout manager is for selecting which type of view will be there, like list, grid, horizontal list
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //setAdapter use the param as the adapter object
        recyclerView.setAdapter(new MyRecyclerAdapter(studentPojos));
    }

    //This will add items to array list
    private void addItemsToArrayList(){
        studentPojos.add(new StudentPojo("Swagata", "1"));
        studentPojos.add(new StudentPojo("Anwesa", "2"));
        studentPojos.add(new StudentPojo("Sayan", "3"));
        studentPojos.add(new StudentPojo("Swagata1", "4"));
        studentPojos.add(new StudentPojo("Anwesa1", "5"));
        studentPojos.add(new StudentPojo("Sayan1", "6"));
    }

    //extends adapter that is defined in RecyclerView class with view holder type
    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {        //the MyViewHolder is defined by user

        //the array list initiated via constructor
        private final ArrayList<StudentPojo> studentPojos;

        //the constructor
        public MyRecyclerAdapter(ArrayList<StudentPojo> studentPojos) {
            this.studentPojos = studentPojos;
        }

        //when new view is created (view == null)
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate for new view
            View rootView = getLayoutInflater().inflate(R.layout.student_layout, parent, false);
            return new MyViewHolder(rootView);              //return the view holder object to be used in the onBindViewHolder method
        }

        //for old view to be reused (else part)
        //this method also called when new view is created, after onCreateViewHolder method is executed
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //get the corresponding student pojo object for a given position
            StudentPojo studentPojo = studentPojos.get(position);
            //update views values
            holder.name.setText(studentPojo.getName());
            holder.roll.setText(studentPojo.getRoll());
        }

        //this will return the number of child items
        @Override
        public int getItemCount() {
            return studentPojos.size();
        }
    }

    //viewholder class for storing created child views and to reuse it
    private class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView roll;
        private final TextView name;

        //constructor with param the created view
        public MyViewHolder(View itemView) {
            //at first call the super view holder constructor
            super(itemView);
            //initiate views
            roll = itemView.findViewById(R.id.rollid);
            name = itemView.findViewById(R.id.nameid);
        }
    }
}
