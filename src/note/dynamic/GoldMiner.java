package note.dynamic;

import java.util.ArrayList;
import java.util.HashMap;

public class GoldMiner {

    private static class Ore {
        int value;
        int miners;

        public Ore(int value, int miners) {
            this.value = value;
            this.miners = miners;
        }
    }

    public static void main(String[] args) {
        ArrayList<Ore> goldOre = new ArrayList<Ore>() {
            {
                add(new Ore(500, 5));

                add(new Ore(200, 3));

                add(new Ore(300, 4));

                add(new Ore(350, 3));

                add(new Ore(400, 5));
            }
        };
        GoldMiner miner = new GoldMiner();
        System.out.println(miner.mine(goldOre, 10));
    }

    /**
     * 有bug
     */
    public int mine2(ArrayList<Ore> ores, int miners) {
        int[] preResults = new int[miners];
        int[] results = new int[miners];
        for (int i = ores.get(0).miners; i < miners; i++) {
            preResults[i] = ores.get(0).value;
        }
        for (int i = 0; i < ores.size(); i++) {
            for (int j = 0; j < miners; j++) {
                if (j < ores.get(i).miners) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j - ores.get(i).miners] + ores.get(i).value);
                }
            }
            preResults = results.clone();
        }
        return results[ores.size() - 1];
    }

    public int mine(ArrayList<Ore> ores, int miners) {
        return mine(ores, ores.size() - 1, miners);
    }

    public int mine(ArrayList<Ore> ores, int index, int miners) {
        Ore ore = ores.get(index);
        if (miners < ore.miners) {
            return 0;
        }
        if (index == 0) {
            return ore.value;
        }
        return Math.max(ore.value + mine(ores, index - 1, miners - ore.miners), mine(ores, index - 1, miners));
    }


}
