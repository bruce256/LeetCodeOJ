package add.binary;

/**
 * @author LvSheng
 * @date 2020/7/5
 **/
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head.next != null) {
            result <<= 1;
            result += head.val;
            head = head.next;
        }

        return result;
    }
}
