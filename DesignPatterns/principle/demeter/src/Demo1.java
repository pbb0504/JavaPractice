import java.util.ArrayList;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/8/17 16:22
 */
public class Demo1 {
    public static void main(String[] args) {
        List<AbnormalStu> abnormalStuList = new SchoolManager().getAllAbnormalStu();
        List<NormalStu> normalStuList = new CollegeManager().getNormalStu();
        for (NormalStu normalStu : normalStuList) {
            System.out.println("normalStu: " + normalStu.getId());
        }
        for (AbnormalStu abnormalStu : abnormalStuList) {
            System.out.println("abnormalStu: " + abnormalStu.getId());
        }
    }
}

class NormalStu {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class AbnormalStu {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class SchoolManager {
    List<AbnormalStu> list = new ArrayList<>();

    List<AbnormalStu> getAllAbnormalStu() {
        for (int i = 0; i < 10; i++) {
            AbnormalStu stu = new AbnormalStu();
            stu.setId(i + 1);
            list.add(stu);
        }
        return list;
    }
}

class CollegeManager {
    List<NormalStu> list = new ArrayList<>();

    List<NormalStu> getNormalStu() {
        for (int i = 0; i < 10; i++) {
            NormalStu stu = new NormalStu();
            stu.setId(i + 1);
            list.add(stu);
        }
        return list;
    }
}
