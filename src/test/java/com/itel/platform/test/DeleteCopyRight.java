
package com.itel.platform.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import java.io.FileOutputStream;
import java.io.InputStreamReader;

import java.nio.ByteBuffer;

import java.nio.channels.FileChannel;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


public class DeleteCopyRight {
  
    public static List<String> getAllFiles(String absoluteDir){   
        //存放所有文件绝对路径名的list   
        List<String> files=new ArrayList<String>();   
        //当前目录的file实例   
        File parentDir=new File(absoluteDir);   
        //列举当前目录下的所有文件和目录的名字   
        String []list=parentDir.list();   
        for(String s: list){   
            //绝对路径名   
            String name=absoluteDir+"/"+s;   
            File instance=new File(name);   
            //如果是文件则添加到list   
            if(instance.isFile()){   
                files.add(name);   
             //如果是目录则使用递归   
            }else{   
                files.addAll(getAllFiles(name));   
            }   
        }   
        return files;   
    }
    /**
     * 找到后缀是java的文件
     * @param list
     * @param suffixs
     * @return
     */
    public static List<String> filteFiles(List<String> list,String[] suffixs){   
        
        Iterator<String> it=list.iterator(); 
        while(it.hasNext()){  
            String s=it.next();   
            boolean isHave=false;
            for(String ext: suffixs){   
                if(s.endsWith("."+ext)){   
                   isHave=true;
                   continue;
                }   
            }
            if(!isHave)
               it.remove();
        }
             
        return list;   
    }  
    public void deleteCopyRight(List<String> list){
        Iterator<String> it=list.iterator(); 
        while(it.hasNext()){  
            String filepath=it.next();   
            try {
                readFile(filepath);
            } catch (Exception e) {                
                e.printStackTrace();
            }
        }
    }
    private  final String beginCopyRight="/*";
    private  final String endCopyRight="*/";
    private  final String packageKey="package";  
    
    public void readFile(String filePath) {
        FileInputStream finStrm = null;
        InputStreamReader instrea = null;
        BufferedReader buffer = null;

        try {
            finStrm = new FileInputStream(filePath);

            instrea = new InputStreamReader(finStrm);
            buffer = new BufferedReader(instrea);

            boolean isfindPackage = false;//false，没有找到package
            boolean isHaveCopyRight = false;//false,没有copyright注释

            ArrayList contentBuffer = new ArrayList();//保存copyright部分内容
            //找到package关键字后，记录下所有的文件内容
            //pachage前的内容不需要了
            while (buffer.ready()) {
                String firstLine = buffer.readLine();

                if (firstLine.contains(packageKey)) {
                    isfindPackage = true;
                    if (!isHaveCopyRight)//没有copyright
                        ;//break;

                }

                if (firstLine.contains(endCopyRight)) {//have copyright
                    if (!isHaveCopyRight&&!isfindPackage) {
                        isHaveCopyRight = true;
                        //break;
                    }
                }
                if(isfindPackage)
                    contentBuffer.add(firstLine);
                //if (isHaveCopyRight && isfindPackage)                   
                    //contentBuffer.add(firstLine);
                
            }
            //
            //if(isHaveCopyRight)
              output(contentBuffer,filePath);

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                finStrm.close();
                instrea.close();
                buffer.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }

   
    String huanhang = System.getProperty("line.separator"); //换行符号
    private  final String huasaicopyright="/*"+huanhang
        +"* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved."+huanhang
        +"*"+huanhang
        +"*"+huanhang
        +"*/";
    public void output(ArrayList alist, String filePath) {
        FileChannel filechannel=null;
        FileOutputStream outstream=null;
        try {
            outstream = new FileOutputStream(filePath);
            filechannel =outstream.getChannel();
            //package前写入华赛copyright信息
            ByteBuffer crByte = ByteBuffer.wrap((huasaicopyright+huanhang).getBytes());
            int crIndex = filechannel.write(crByte);
            for(int i=0;i<alist.size();i++){
                
                String contensre=(String) alist.get(i);
                //System.out.println("------------------stringlist---------"+contensre);
                byte[] arr = (contensre + huanhang).getBytes();

                ByteBuffer contentBuffer = ByteBuffer.wrap(arr);
                filechannel.write(contentBuffer, crIndex);// 一段一段写入
                crIndex+=arr.length;
                
            }
           
          

        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            try {
                if(outstream!=null)
                outstream.close();
                filechannel.close();
            } catch (IOException e) {
               
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws Exception {   
        //路径名要使用绝对路径，形式如H:/Logo   
       
        List<String> list=getAllFiles("src/main/java/com/weheros/platform");   
        //src/test/java/com/huaweisymantec/ucm/jcr
        //kernel/container/src/main/java/com/huaweisymantec/
        //kernel/commons/src/main/java/com/huaweisymantec
        //kernel/component/src/main/java/com/huaweisymantec
        //core/component/src/main/java/com/huaweisymantec
        //jcr/rmi/src/main/java/com/huaweisymantec
        //List<String> list=getAllFiles("src/learn/java/lxiaodao/language");  
        list=filteFiles(list,new String[]{"java"});
        System.out.println("----------------需要替换copyright的文件---------------");
        for(String s: list){   
            System.out.println(s);   
        }       
        // /r/n    /n
        String huanhang=System.getProperty("line.separator");
        System.out.print(huanhang);
        System.out.println("----------------开始替换copyright---------------");
        //删除copyright
        new DeleteCopyRight().deleteCopyRight(list);
        System.out.println("----------------完成替换copyright---------------");
    }
}

