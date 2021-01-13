package example.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: HeapOOM
 * @Description:
 * @VM_Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @Result: java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOM {
    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while(true) {
            list.add(new OOMObject());
        }
    }
}
