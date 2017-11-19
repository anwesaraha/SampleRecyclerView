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
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerAdapter(studentPojos));
    }

    private void addItemsToArrayList(){
        studentPojos.add(new StudentPojo("Swagata", "1"));
        studentPojos.add(new StudentPojo("Anwesa", "2"));
        studentPojos.add(new StudentPojo("Sayan", "3"));
        studentPojos.add(new StudentPojo("Swagata1", "4"));
        studentPojos.add(new StudentPojo("Anwesa1", "5"));
        studentPojos.add(new StudentPojo("Sayan1", "6"));
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private final ArrayList<StudentPojo> studentPojos;

        public MyRecyclerAdapter(ArrayList<StudentPojo> studentPojos) {
            this.studentPojos = studentPojos;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = getLayoutInflater().inflate(R.layout.student_layout, parent, false);
            return new MyViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            StudentPojo studentPojo = studentPojos.get(position);
            holder.name.setText(studentPojo.getName());
            holder.roll.setText(studentPojo.getRoll());
        }

        @Override
        public int getItemCount() {
            return studentPojos.size();
        }
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView roll;
        private final TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            roll = itemView.findViewById(R.id.rollid);
            name = itemView.findViewById(R.id.nameid);
        }
    }
}
