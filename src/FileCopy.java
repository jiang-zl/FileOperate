import java.io.*;

/**
 * @author : jiangzhengliang
 * @Data : 2020-08-01
 * @Direction : be used to copy file A to file B
 * @Character : the copied file is a java programming code
 */
public class FileCopy {

    public static void fileCopy(String srcFileName, String desFileName) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFileName)
        );
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(desFileName)
        );
        byte[] buffer = new byte[10 * 1024];
        int len = -1;
        while((len = bis.read(buffer, 0, buffer.length)) != -1){
            bos.write(buffer);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    public static void displayFileContent(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName)
                )
        );
        String strLine = null;
        while((strLine = br.readLine()) != null){
            System.out.println(strLine);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        String src = "TestFiles\\CopyFile1.txt";
        String des = "TestFiles\\CopyFile2.txt";
        try {
            fileCopy(src, des);
            System.out.println("拷贝成功！展示新的文件内容：");
            displayFileContent(des);
        }
        catch (IOException ioe){
            System.out.println("文件不存在！");
        }
    }
}
