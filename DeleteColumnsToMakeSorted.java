public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int deleteCount = 0;

        for (int col = 0; col < cols; col++) {

            for (int row = 1; row < rows; row++) {

                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }

    public static void main(String[] args) {

        DeleteColumnsToMakeSorted obj = new DeleteColumnsToMakeSorted();

        String[] strs = {"cba", "daf", "ghi"};

        int result = obj.minDeletionSize(strs);

        System.out.println("Columns to delete: " + result);
    }
}