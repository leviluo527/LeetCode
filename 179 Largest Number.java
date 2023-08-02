class Solution {
    public String largestNumber(int[] nums) {
        // Convert int array to Integer array
        Integer[] numArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArray[i] = nums[i];
        }

        // Custom comparator to sort the Integer array
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                // Concatenate the numbers in different order and compare them
                String s1 = String.valueOf(num1);
                String s2 = String.valueOf(num2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        };

        // Sort the Integer array using the custom comparator
        Arrays.sort(numArray, customComparator);

        // Handle the edge case where all elements in the array are zeros
        if (numArray[0] == 0) {
            return "0";
        }

        // Concatenate the sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (Integer num : numArray) {
            result.append(num);
        }

        return result.toString();
    }
}