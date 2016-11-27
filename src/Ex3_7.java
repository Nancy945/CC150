/**
有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
给定一个操作序列int[][2] ope代表所有事件。若第一个元素为1，则代表有动物进入收容所，
第二个元素为动物的编号，正数代表狗，负数代表猫；
若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
*/

/**
* 猫狗收容所
* @param ope
* @return
*/
public class Ex3_7{
	private static ArrayList<Integer> asylum(int[][] ope){
	ArrayList<Integer> list = new ArrayList<>();
	ArrayDeque<Integer> dog = new ArrayDeque<>();
	ArrayDeque<Integer> cat = new ArrayDeque<>();
	ArrayDeque<Integer> comp = new ArrayDeque<>();
		
	for (int i = 0; i < ope.length; i++) {
		int io = ope[i][0];
		int type = ope[i][1];
		if (io == 1) {//有动物进入收容所
			if (type > 0) {//狗进入
				dog.add(type);
				comp.add(1);//用于记录收养狗的标记
			} else if(type < 0) {//猫进入
				cat.add(type);
				comp.add(0);//用于记录收养猫的标记
			}
			
		} else if (io == 2) {//有人要从收容所领养动物
			if (comp.size() == 0) {
				continue;     //忽略本次错误的领养
			}
			if (type == -1 && cat.size() != 0) {//收养猫
				list.add(cat.peek());
				cat.pop();
				comp.remove(0);
			} else if (type == 0) {
				if (comp.peek() == 1 && dog.size() != 0) {//狗被收养的时间最长
					list.add(dog.peek());
					dog.pop();
				} else if(comp.peek() == 0 && cat.size() != 0) {//猫被收养的时间最长
					list.add(cat.peek());
					cat.pop();
				}
				comp.pop();
			} else if(type == 1 && dog.size() != 0) {//收养狗
				list.add(dog.peek());
				dog.pop();
				comp.remove(1);
			}
		}
	}
	return list;
	}
	
	/**
	第二种方法
	*/
	public class CatDogAsylum {
		public ArrayList<Integer> asylum(int[][] ope) {
			Queue<Integer> dog=new LinkedList<Integer>();
			Queue<Integer> cat=new LinkedList<Integer>();
			Queue<Integer> all=new LinkedList<Integer>();
			ArrayList<Integer> animal=new ArrayList<Integer>();
			for(int i=0;i<ope.length;i++){
				if(ope[i][0]==1){//有动物进入收容所
					all.add(ope[i][1]);
					if(ope[i][1]>0)
						dog.add(ope[i][1]);
					else if(ope[i][1]<0)
						cat.add(ope[i][1]);
				}else if(ope[i][0]==2){//有人要从收容所领养动物
					if(ope[i][1]==0){//第一种收养方式
						if(!all.isEmpty()){
							//看最先被领养的是猫还是狗 同步删除猫或狗中的stack
							int temp=all.poll();
							animal.add(temp);
							if(temp>0)
								dog.poll();
							else
								cat.poll();
						}
					}else if(ope[i][1]>0){//收养狗
						if(!dog.isEmpty()){
							//看最先被领养的是猫还是狗 同步删除混合stack中的值
							int temp=dog.poll();
							animal.add(temp);
							all.remove(temp);
						}
					}else{//收养猫
						if(!cat.isEmpty()){
							//看最先被领养的是猫还是狗 同步删除混合stack中的值
							int temp=cat.poll();
							animal.add(temp);
							all.remove(temp);
						}
					}
				}
			}
			return animal;
		}
	}
}
	ArrayList<Integer> list = new ArrayList<>();
	ArrayDeque<Integer> dog = new ArrayDeque<>();
	ArrayDeque<Integer> cat = new ArrayDeque<>();
	ArrayDeque<Integer> comp = new ArrayDeque<>();
		
	for (int i = 0; i < ope.length; i++) {
		int io = ope[i][0];
		int type = ope[i][1];
		if (io == 1) {//有动物进入收容所
			if (type > 0) {//狗进入
				dog.add(type);
				comp.add(1);//用于记录收养狗的标记
			} else if(type < 0) {//猫进入
				cat.add(type);
				comp.add(0);//用于记录收养猫的标记
			}
			
		} else if (io == 2) {//有人要从收容所领养动物
			if (comp.size() == 0) {
				continue;     //忽略本次错误的领养
			}
			if (type == -1 && cat.size() != 0) {//收养猫
				list.add(cat.peek());
				cat.pop();
				comp.remove(0);
			} else if (type == 0) {
				if (comp.peek() == 1 && dog.size() != 0) {//狗被收养的时间最长
					list.add(dog.peek());
					dog.pop();
				} else if(comp.peek() == 0 && cat.size() != 0) {//猫被收养的时间最长
					list.add(cat.peek());
					cat.pop();
				}
				comp.pop();
			} else if(type == 1 && dog.size() != 0) {//收养狗
				list.add(dog.peek());
				dog.pop();
				comp.remove(1);
			}
		}
	}
	return list;
}