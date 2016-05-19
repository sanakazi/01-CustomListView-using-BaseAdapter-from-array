package com.example.custlistview;


import java.util.ArrayList;


import android.os.Bundle;

import android.app.Activity;
import android.content.res.Resources;

import android.util.Log;

import android.view.Menu;

import android.widget.ListView;

import android.widget.Toast;





public class MainActivity extends Activity 
{
  ListView list;
    
  CustomAdapter adapter;

  
  public  ArrayList<ListModel> arr = new ArrayList<ListModel>();
    

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {


       
  super.onCreate(savedInstanceState);
       
  setContentView(R.layout.activity_main);
  

    /******** Take some data in Arraylist ( MainActivityArr ) ***********/
    
    setListData();
         
       
   Resources res =getResources();
      
  list= ( ListView )findViewById( R.id.list );  

// List defined in XML ( See Below )
         
    

    /**************** Create Custom Adapter *********/
     
   adapter=new CustomAdapter( MainActivity.this, arr,res );
  
      list.setAdapter( adapter );
      
   
    }
 
  

  /****** Function to set data in ArrayList *************/
  


  public void setListData()
  

  {
         
       
 for (int i = 0; i < 11; i++) {
   
      final ListModel sched = new ListModel();
      
    /******* Firstly take data in model object ******/
     
        sched.setCompanyName("Company "+i);
       
        sched.setImage("image"+i);
         
        sched.setUrl("http:\\www."+i+".com");
      


          
            /******** Take Model Object in ArrayList **********/
      
      arr.add( sched );
     
       
        }
       
  Log.d("Elements", arr.toString());
   
 }
   
 

  

 /*****************  This function used by adapter ****************/
  
  public void onItemClick(int mPosition)
    {
     
   ListModel tempValues = ( ListModel ) arr.get(mPosition);


       
// SHOW ALERT                  


        Toast.makeText(MainActivity.this,""+tempValues.getCompanyName()
        		+" Image:"+tempValues.getImage()
                  +" Url:"+tempValues.getUrl(),
                Toast.LENGTH_LONG)
        .show();
    }

}