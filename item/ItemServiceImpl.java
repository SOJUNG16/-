package item;

public class ItemServiceImpl implements ItemService {
	private Item[] lists;
	private int index;
	
	//new serviceimpl
	public ItemServiceImpl() {
		lists = new Item[3];
		index = 0;
	}

	@Override
	public void addCart(Item item) {
//		if(index >= 3) {
//			System.out.println("오류"); // 오류처리
//		}else {
		lists[index] = item; //리스트에 담기
		index++;
		}

	@Override
	//전체가져오기
	public Item[] list() {
		return lists;
	}


}