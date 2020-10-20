package com.li.principle.inversionn;

public class DependencyPass {

	public static void main(String[] args) {
		//通过接口传递
		// new OpenAndClose().open(new Tv());

		//通过构造器传递
		// new OpenAndClose(new Tv()).open();

		//通过setter
		OpenAndClose openAndClose = new OpenAndClose();
		openAndClose.setTv(new Tv());
		openAndClose.open();

	}

}


class Tv implements ITV{

	@Override
	public void play() {
		System.out.println("tv .............");
	}
}

// 方式1： 通过接口传递实现依赖
// 开关的接口
// interface IOpenAndClose {
// 	public void open(ITV tv); //抽象方法,接收接口
// }
//
// interface ITV { //ITV接口
// 	public void play();
// }
//
// // 实现接口
// class OpenAndClose implements IOpenAndClose {
// 	public void open(ITV tv) {
// 		tv.play();
// 	}
// }


// 方式2: 通过构造方法依赖传递
// interface IOpenAndClose {
// 	public void open(); //抽象方法,接收接口
// }
//
// interface ITV { //ITV接口
// 	public void play();
// }
//
// // 实现接口
// class OpenAndClose implements IOpenAndClose {
// 	//成员
// 	private ITV tv;
//
// 	//构造器
// 	public OpenAndClose(ITV tv) {
// 		this.tv = tv;
// 	}
//
// 	public void open() {
// 		this.tv.play();
// 	}
// }



// 方式3 , 通过setter方法传递
interface IOpenAndClose {
	public void open(); // 抽象方法

	public void setTv(ITV tv);
}

interface ITV { // ITV接口
	public void play();
}

class OpenAndClose implements IOpenAndClose {
	private ITV tv;

	public void setTv(ITV tv) {
		this.tv = tv;
	}

	public void open() {
		this.tv.play();
	}
}
