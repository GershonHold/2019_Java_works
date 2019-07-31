import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Date extends JFrame {

    public void Background() {
        setTitle("古代纪时");
        //定义标签
        JLabel storage;

        Calendar now = Calendar.getInstance();
        //获取文本标签text1
        String text1 = "<html>今天是：" + now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) + "日" + "<br/>现在是：" + now.get(Calendar.HOUR_OF_DAY) + "时" + now.get(Calendar.MINUTE) + "分" + now.get(Calendar.SECOND) + "秒";

        storage = new JLabel(text1);
        //以下为配置text1参数
        storage.setHorizontalAlignment(SwingConstants.CENTER);
        storage.setBounds(108, 70, 253, 28);//标签位置
        storage.setForeground(Color.white);
        add(storage);

        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("/Users/hgs/Pictures/menghuichangan.jpg"); //添加图片
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        Container c = getContentPane(); //获取JFrame面板
        JPanel jp = new JPanel(); //创建个JPanel
        jp.setOpaque(false); //把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
        c.add(jp);

        setSize(500, 500);
        setVisible(true);
    }

    public int GetNum() {

        Calendar now = Calendar.getInstance();
        int i = ((now.get(Calendar.MONTH) + 1) % 2);//i的值，奇数月i=0，偶数月i=6
        if (i == 0)
            i = 6;
        else
            i = 0;

        /*计算公式
        G = 4C + [C / 4] + 5y + [y / 4] + [3 * (M + 1) / 5] + d - 3
        Z = 8C + [C / 4] + 5y + [y / 4] + [3 * (M + 1) / 5] + d + 7 + i*/
        int G = 4 * ((now.get(Calendar.YEAR)) / 100 - 1) + (((now.get(Calendar.YEAR)) / 100 - 1) / 4) + 5 * (now.get(Calendar.YEAR) % 100) + ((now.get(Calendar.YEAR) % 100) / 4) + (3 * (now.get(Calendar.MONTH) + 1) / 5) + now.get(Calendar.DAY_OF_MONTH) - 3;
        int Z = 8 * ((now.get(Calendar.YEAR)) / 100 - 1) + (((now.get(Calendar.YEAR)) / 100 - 1) / 4) + 5 * (now.get(Calendar.YEAR) % 100) + ((now.get(Calendar.YEAR) % 100) / 4) + (3 * (now.get(Calendar.MONTH) + 1) / 5) + now.get(Calendar.DAY_OF_MONTH) + 7 + i;
        int H = now.get(Calendar.HOUR_OF_DAY);

        Judge(G, Z, H);

        return 0;
    }

    public void Judge(int x, int y, int z) {
        //开始判断天干
        String text2, text3;
        switch (x % 10) {
            case 1:
                text2 = "今天是甲   ";
                TextLabel(text2);
                break;
            case 2:
                text2 = "今天是乙   ";
                TextLabel(text2);
                break;
            case 3:
                text2 = "今天是丙   ";
                TextLabel(text2);
                break;
            case 4:
                text2 = "今天是丁   ";
                TextLabel(text2);
                break;
            case 5:
                text2 = "今天是戊   ";
                TextLabel(text2);
                break;
            case 6:
                text2 = "今天是己   ";
                TextLabel(text2);
                break;
            case 7:
                text2 = "今天是庚   ";
                TextLabel(text2);
                break;
            case 8:
                text2 = "今天是辛   ";
                TextLabel(text2);
                break;
            case 9:
                text2 = "今天是壬   ";
                TextLabel(text2);
                break;
            case 0:
                text2 = "今天是癸   ";
                TextLabel(text2);
                break;
        }

        //开始判断地支

        switch (y % 12) {
            case 1:
                text3 = "                 子日";
                TextLabel(text3);
                break;
            case 2:
                text3 = "                 丑日";
                TextLabel(text3);
                break;
            case 3:
                text3 = "                 寅日";
                TextLabel(text3);
                break;
            case 4:
                text3 = "                 卯日";
                TextLabel(text3);
                break;
            case 5:
                text3 = "                 辰日";
                TextLabel(text3);
                break;
            case 6:
                text3 = "                 巳日";
                TextLabel(text3);
                break;
            case 7:
                text3 = "                 午日";
                TextLabel(text3);
                break;
            case 8:
                text3 = "                 未日";
                TextLabel(text3);
                break;
            case 9:
                text3 = "                 申日";
                TextLabel(text3);
                break;
            case 10:
                text3 = "                 酉日";
                TextLabel(text3);
                break;
            case 11:
                text3 = "                 戊日";
                TextLabel(text3);
                break;
            case 0:
                text3 = "                 亥日";
                TextLabel(text3);
                break;
        }

        //判断日夜十二时辰的变化
        String text4;
        if (z == 23 || z == 0)
            text4 = "                                           时辰：夜半";
        else if (z == 1 || z == 2)
            text4 = "                                           时辰：鸡鸣";
        else if (z == 3 || z == 4)
            text4 = "                                             时辰：平旦";
        else if (z == 5 || z == 6)
            text4 = "                                             时辰：日出";
        else if (z == 7 || z == 8)
            text4 = "                                             时辰：食时";
        else if (z == 9 || z == 10)
            text4 = "                                             时辰：隅中";
        else if (z == 11 || z == 12)
            text4 = "                                             时辰：日中";
        else if (z == 13 || z == 14)
            text4 = "                                             时辰：日昳";
        else if (z == 15 || z == 16)
            text4 = "                                             时辰：晡时";
        else if (z == 17 || z == 18)
            text4 = "                                             时辰：日入";
        else if (z == 19 || z == 20)
            text4 = "                                             时辰：黄昏";
        else
            text4 = "                                             时辰：人定";

        TextLabel(text4);

    }

    public void TextLabel(String text) {
        JLabel storage1;
        storage1 = new JLabel(text);
        //以下为配置text1参数
        storage1.setHorizontalAlignment(SwingConstants.CENTER);
        storage1.setBounds(65, 115, 253, 28);//标签位置
        storage1.setForeground(Color.WHITE);
        add(storage1);
    }

}