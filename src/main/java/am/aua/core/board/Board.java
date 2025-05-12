package am.aua.core.board;

import am.aua.constants.Resources;

import java.util.*;

public class Board {
    private final Area[][] areas;

    public Board() {
        Resources[] resources = new Resources[] { Resources.GRAIN, Resources.GRAIN, Resources.GRAIN, Resources.GRAIN, Resources.WOOL, Resources.WOOL, Resources.WOOL, Resources.WOOL, Resources.LUMBER, Resources.LUMBER, Resources.LUMBER, Resources.LUMBER, Resources.BRICK, Resources.BRICK, Resources.BRICK, Resources.ORE, Resources.ORE, Resources.ORE };
        int[] numbers = new int[] { 2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12 };
        List<Resources> resourceList = Arrays.asList(resources.clone());
        List<Integer> numberList = new ArrayList<>();
        for (int num : numbers) numberList.add(num);

        Collections.shuffle(resourceList);
        Collections.shuffle(numberList);
        ResourceArea[] cells = new ResourceArea[resources.length];

        for (int i = 0; i < resourceList.size(); i++) {
            cells[i] = new ResourceArea(resourceList.get(i), numberList.get(i));
        }

        areas = new Area[][] {
                {       cells[0],      cells[1],      cells[2]                  },
                {   cells[3],   cells[4],   cells[5],   cells[6]                },
                {cells[7],  cells[8],  new Desert(), cells[9],    cells[10]     },
                {   cells[11],   cells[12], cells[13],   cells[14]              },
                {       cells[15],    cells[16],     cells[17]                  },
        };
    }

    public Area[][] getAreas() {
        return areas;
    }

    public Area getArea(int row, int col) {
        return areas[row][col];
    }

    public ArrayList<Area> getAreasByNumber(int number) {
        ArrayList<Area> areasList = new ArrayList<>();

        for (Area[] rowOfAreas : areas) {
            for (Area area : rowOfAreas) {
                if (area instanceof ResourceArea) {
                    if(((ResourceArea) area).getNumber() == number) areasList.add(area);
                }
            }
        }

        return areasList;
    }

    public int[] getPositionOfArea(Area area) {
        int[] position = new int[2];

        for (int i = 0; i < areas.length; i++) {
            for (int j = 0; j < areas[i].length; j++) {
                if (area.equals(areas[i][j])) {
                    position[0] = i+1;
                    position[1] = j+1;
                    return position;
                }
            }
        }

        return position;
    }

    public Area findAreaWithRobber() {
        for (Area[] areaRow: areas) {
            for (Area area: areaRow) {
                if(area.getIsRobberOverIt()) return area;
            }
        }
        return areas[2][2];
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
