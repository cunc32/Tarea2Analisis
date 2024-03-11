package com.mycompany.vanguardia;

class MergeSort {
 
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 7013, 8265, 6036, 3033, 8164, 1868, 6062, 7810, 3361, 6562, 7248, 1807, 3176, 1399, 3461, 3608, 9509, 5428, 2562, 623, 202, 5302, 1122, 7990, 1491, 6511, 7856, 581, 6094, 3143, 4749, 8292, 897, 6811, 6056, 2481, 9786, 8816, 122, 515, 3710, 3128, 9428, 3125, 9957, 1385, 959, 3156, 7098, 5538, 5237, 6162, 3941, 5009, 8684, 2024, 248, 8384, 160, 6567, 1924, 3664, 9438, 2445, 3993, 6339, 2148, 4301, 5513, 9857, 5185, 2080, 9029, 3356, 4808, 6732, 7001, 3929, 2652, 452, 9700, 5235, 9924, 2163, 3477, 5825, 9288, 595, 9516, 6743, 5014, 6850, 7741, 8785, 2590, 3953, 4262, 4015, 7158, 3704, 1494, 788, 6282, 3127, 8525, 8028, 9091, 6362, 8359, 318, 9970, 4818, 659, 8289, 8030, 9073, 6694, 4865, 9767, 5904, 4530, 9811, 5139, 1550, 9625, 4728, 638, 9398, 9940, 3893, 5866, 4189, 4303, 9461, 7826, 6565, 2112, 2814, 9100, 4348, 2382, 5140, 3818, 237, 5150, 9191, 5262, 2786, 4977, 4612, 1720, 9114, 1233, 2448, 9557, 5205, 8902, 7397, 4943, 1874, 9437, 4425, 4489, 6625, 1312, 5474, 9119, 7121, 5367, 9139, 1039, 5318, 5673, 976, 6887, 5751, 6140, 9534, 1524, 8980, 7513, 1558, 9883, 8382, 9724, 9990, 5985, 448, 6313, 7707, 5022, 6723, 6790, 4005, 7536, 1816, 7747, 8561, 5738, 2178, 8396, 3173, 8497, 3880, 8723, 5392, 5477, 2270, 7453, 1764, 7255, 8128, 6990, 3220, 8445, 5918, 7904, 9228, 8465, 6813, 8851, 6414, 1013, 7354, 2570, 4852, 8597, 6979, 4147, 7107, 2778, 4234, 8557, 6574, 1826, 3308, 1891, 7683, 175, 7958, 8032, 1662, 5242, 713, 5650, 6601, 1575, 2879, 2945, 7205, 24, 9110, 7210, 4054, 2092, 3609, 9333, 4713, 9534, 7806, 1525, 2434, 4964, 8074, 9974, 1847, 5181, 690, 818, 5419, 2336, 3644, 4699, 9966, 5713, 2437, 6773, 2320, 9399, 1698, 3934, 284, 6839, 9937, 7374, 1531, 5693, 2887, 5179, 6167, 2312, 4961, 9763, 3110, 8961, 974, 5373, 8666, 255, 8145, 6793, 4674, 612, 4625, 6343, 9063, 9338, 8559, 9865, 9175, 699, 4015, 5841, 1119, 3292, 9170, 5061, 7635, 5093, 3167, 8268, 4427, 234, 6191, 2085, 3478, 5527, 1525, 3226, 3190, 5319, 9414, 7181, 4401, 4583, 7018, 8635, 9597, 7046, 5607, 1671, 286, 2982, 5736, 8199, 7926, 8384, 9742, 895, 2098, 5578, 2147, 3843, 2843, 5825, 820, 36, 6517, 6125, 4619, 829, 184, 8330, 121, 4025, 7293, 3203, 2490, 9063, 4733, 8696, 5568, 1214, 146, 5013, 8734, 1360, 3474, 9505, 388, 8665, 2036, 8892, 7965, 9043, 4897, 4600, 8335, 1788, 3314, 3983, 6307, 2357, 9619, 5618, 1317, 8199, 550, 2564, 6901, 9090, 8334, 7890, 3050, 9670, 9611, 7848, 7757, 1921, 9829, 4694, 5981, 6892, 4069, 8725, 5616, 3094, 4950, 7828, 6983, 6712, 6168, 801, 4050, 137, 2221, 8133, 104, 48, 1437, 4948, 7580, 9913, 9101, 7280, 1132, 6314, 2659, 1154, 105, 8807, 4227, 955, 7366, 8488, 5846, 1215, 7034, 2667, 1439, 8288, 821, 2206, 9793, 371, 1036, 6294, 9145, 5489, 9828, 2894, 1764, 5181, 2380, 604, 5852, 2642, 888, 8195, 720, 2516, 9684, 9731, 3798, 9570, 2736, 7922, 2365, 4741, 7838, 6812, 7597, 2161, 8625, 798, 6033, 7723, 7267, 9027, 5029, 3329, 2608, 5014, 1454, 6422, 8479, 5101, 6425, 6873, 558, 5262, 9721, 925, 8897, 1477, 3927, 3661, 8284, 8170, 6789, 6646, 4836, 7112, 9004, 4200, 7461, 6990, 7912, 1307, 9118, 3414, 5016, 1677, 82, 868, 6415, 927, 7135, 4447, 7018, 5991, 4166, 7917, 7793, 6413, 9588, 2022, 8439, 8963, 6622, 5816, 4407, 2683, 2284, 4892, 6139, 5021, 1406, 4639, 1628, 4102, 1237, 7753, 5681, 8458, 8132, 760, 9842, 5968, 146, 9495, 9221, 8972, 2532, 1194, 9315, 2867, 3111, 9354, 1555, 8861, 25, 6538, 4778, 5148, 3535, 9372, 1629, 4374, 1599, 1668, 9121, 5325, 399, 7982, 9235, 9885, 5424, 9772, 1381, 6494, 400, 7145, 819, 5963, 8756, 1969, 2254, 7137, 5099, 3470, 1176, 155, 2308, 8312, 295, 9605, 505, 7937, 4726, 4057, 6200, 6004, 9319, 2877, 8920, 4592, 1859, 8514, 9862, 7251, 8683, 9360, 4141, 1127, 902, 9363, 1278, 7826, 3472, 8539, 2497, 1198, 8840, 2184, 7640, 3688, 4198, 3034, 3076, 2754, 1923, 244, 7873, 6108, 3814, 4695, 8788, 928, 7648, 4000, 5560, 1693, 1849, 9033, 7880, 1699, 3741, 2789, 1743, 2133, 8183, 159, 1472, 6018, 2735, 5347, 2856, 6675, 2621, 6009, 1235, 8487, 3195, 8089, 7038, 9674, 408, 2285, 3546, 1160, 6165, 1544, 3022, 752, 616, 4427, 6381, 4318, 6340, 4111, 2173, 5450, 8274, 8064, 8538, 8946, 8055, 4854, 44, 1009, 6945, 5461, 5556, 98, 6892, 6812, 6824, 6166, 1481, 7012, 25, 4655, 4407, 423, 7624, 5859, 4516, 4457, 7524, 7048, 7442, 2926, 3274, 6929, 8266, 4608, 6076, 7031, 4574, 8986, 2991, 3946, 1855, 9564, 5267, 1822, 6511, 9185, 2176, 2717, 6506, 4032, 7800, 8679, 6371, 7779, 9300, 9686, 8769, 8567, 8762, 8025, 13, 9659, 8213, 7319, 4497, 6761, 914, 8045, 4292, 3911, 8644, 1748, 5056, 8502, 7177, 9737, 2482, 4432, 5704, 9656, 5631, 7623, 2220, 4358, 2255, 7229, 7146, 7514, 8154, 7599, 7179, 3741, 3103, 6943, 1441, 3655, 6708, 5116, 9593, 2885, 6671, 5413, 1358, 5567, 7158, 2108, 6060, 2628, 6572, 6324, 6623, 8189, 1518, 5427, 2588, 8120, 7021, 947, 4459, 2579, 7467, 364, 6000, 4844, 7307, 2871, 9394, 8018, 7975, 2983, 5137, 2913, 6185, 2176, 5162, 51, 3635, 5032, 7019, 3546, 3714, 4796, 3868, 2492, 8643, 6235, 8526, 2224, 7492, 6061, 2629, 7772, 2338, 9056, 2364, 5384, 9301, 4921, 2419, 6138, 3372, 7483, 1568, 1627, 202, 7058, 8646, 1447, 1744, 3283, 8869, 6518, 1917, 9641, 5280, 7693, 357, 8740, 574, 1569, 5484, 2556, 1532, 9581, 6690, 188, 7418, 3436, 2140, 5836, 7119, 7240, 8981, 7070, 9272, 3766, 7293, 4581, 896, 4007, 1303, 8195, 7148, 3662, 261, 7305, 315, 121, 6707, 4544, 6578, 3451, 9308, 5362, 7959, 7006, 4636, 1127, 2255, 5514, 3337, 8845, 4988, 3603, 9954, 9373, 8588, 6998, 2411, 1194, 6539, 4602, 5630, 493, 284, 4682, 7205, 3284, 724, 5993, 9082, 5825, 9301, 376, 8325, 4316, 2090, 7647, 7632, 8716, 3134, 7799, 5459, 5809, 4248, 3049, 975, 8309, 7244, 4603, 5441, 5885, 498, 7781, 8849, 8993, 2186, 9810, 1286, 3390, 5991, 8902, 2323, 2473, 1289, 7443, 7854, 4071, 7163, 9733, 581, 1801, 2966, 5428, 7143, 3264, 3014, 1922, 7573, 9968, 4324, 4662, 1388, 1849, 5597, 4673, 9041, 2976, 2814, 4891, 1230, 9358, 6857, 5015, 2481, 6510, 4396 };
 
        System.out.println("Given array is");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array is");
        printArray(arr);
    }
}