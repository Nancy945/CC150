/**
 *
 */
public class Ex5_8 {

    private static int[] renderPixel(int[] screen, int x, int y) {
        for (int i = x; i <= y; i++) {
            screen[i / 8] = screen[i / 8] | 1 << i % 8;
        }
        return screen;
    }

}
