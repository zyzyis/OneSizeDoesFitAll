#define secret 35317
#define is_touched(v) ((v) >= secret && (v) % secret == 0)

int findDuplicate(int* nums, int numsSize) {
    int index = 0, i = 0, j = 0, result = 0;
    for (i = 0; i < numsSize; i ++) {
        index = is_touched(nums[i]) ? nums[i] / secret : nums[i];
        if (is_touched(nums[index])) {
            result = index;
            j = i;
            break;
        } else
            nums[index] *= secret;
    }
    // untouch the array
    for (i = 0; i < j; i ++)
        if (is_touched(nums[i]))
            nums[i] /= secret;
    return result;
}
