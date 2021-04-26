package cc.fyp.test.innerInterface;

/**
 * @author von
 * @description:
 * @date 2021/4/26 10:12
 */
public class AsiaPepole implements Pepole{
    @Override
    public int ears() {
        return 0;
    }

    class AsiaMove implements Pepole.Move{

        @Override
        public int eat() {
            return 0;
        }

        @Override
        public int work() {
            return 0;
        }
    }

}
