#include "elevator struct.h"

extern HEGG main_egg;//主蛋的句柄
int bitmap=0;

typedef struct
{
	char order;//对应键盘输入的字符
	int value;//0表示无请求 1表示在请求
}Order;

mouse find_order(char order);//输入对应指令，返回对应指令的信息（mouse类型数据）
void reversal_bitmap(Order current);//传进指令对应的字符情况，改变该指令对应的图片（0改1，1改0）
void egg_order_change(Order current[],Order previous[],int size);
/*传进当前时刻和前一时刻的指令情况(下标从0开始)，以及指令数组的大小(size),进行指令界面切换*/

void egg_order()
{
	const char ask_ch[]={"0123456789IUYTREWQKJHGFDSA"};

	static Order previous[26];//上一时刻的指令状况(下标从0开始)
	static Order current[26];//当前时刻的指令状况(下标从0开始)
	static int flag=0;//flag=0表示第一次调用本函数
	int i;

	void egg_trans(Order current[26]);//egg_order.c中用于遍历转换输入的数组

	if(!flag)
		for (i=0;i<26;i++)
		{
			previous[i].order=ask_ch[i];
			current[i].order=ask_ch[i];
			flag=1;
		}//指令字符初始化

	for (i=1;i<26;i++)
		current[i].value=0;

	egg_trans(current);//转换输入
	egg_order_change(current,previous,26);

	for (i=0;i<=25;i++)
		previous[i]=current[i];
	return;
}

void egg_order_change(Order current[],Order previous[],int size)
/*传进当前时刻和前一时刻的指令情况(下标从0开始)，以及指令数组的大小(size),进行指令界面切换*/
{
	int i;

	for (i=0;i<size;i++)
		if (current[i].value!=previous[i].value)//指令情况有变化
		//	while (main_egg!=GetActiveEgg());
			reversal_bitmap(current[i]);//改变该指令对应的图片

	return;
}

mouse find_order(char order)//输入对应指令，返回对应指令的信息（mouse类型数据）
{
	int i;
	for (i=0;i<KEY_AMOUNT;i++)
		if (click_position[i].order==order)
			return click_position[i];
	return click_position[i-1];
}

void reversal_bitmap(Order current)//传进指令对应的字符情况，改变该指令对应的图片（0改1，1改0）
{
	mouse click;//当前的键

	click=find_order(current.order);//返回需要改变的键

	if(current.value==1)//需要0改1,改成待响应
	{
		while(animation==1);

		bitmap=1;
		SetActiveEgg(main_egg);
		MovePen(click.leftup_x,click.leftup_y);
		DrawBitmap(click.bitmap_name2);
		bitmap=0;
	}
	else//需要1改0，改成无请求
	{
		while (animation==1);

		bitmap=1;
		SetActiveEgg(main_egg);
		MovePen(click.leftup_x,click.leftup_y);
		DrawBitmap(click.bitmap_name1);
		bitmap=0;
	}

	return;
}

void egg_trans(Order current[26])//egg_order.c中用于遍历转换输入的数组
{
	int i;
	int floor=0;

	for (i=1;i<=size;i++)
	{
		if (input[i].is_done==0)//没有被响应的请求
		{
			if (input[i].order<='9' && input[i].order>=1)//内部请求(0 ~ 9)
				current[input[i].order-48].value=1;

			else//外部请求
			{
				switch (input[i].order)
				{
				case 'I':case 'i'://八层上行
					current[10].value=1;
					break;
				case 'U':case 'u'://七层上行
					current[11].value=1;
					break;
				case 'Y':case 'y'://六层上行
					current[12].value=1;
					break;
				case 'T':case 't'://五层上行
					current[13].value=1;
					break;
				case 'R':case 'r'://四层上行
					current[14].value=1;
					break;
				case 'E':case 'e'://三层上行
					current[15].value=1;
					break;
				case 'W':case 'w'://二层上行
					current[16].value=1;
					break;
				case 'Q':case 'q'://一层上行
					current[17].value=1;
					break;
				case 'K':case 'k'://九层下行
					current[18].value=1;
					break;
				case 'J':case 'j'://八层下行
					current[19].value=1;
					break;
				case 'H':case 'h'://七层下行
					current[20].value=1;
					break;
				case 'G':case 'g'://六层下行
					current[21].value=1;
					break;
				case 'F':case 'f'://五层下行
					current[22].value=1;
					break;
				case 'D':case 'd'://四层下行
					current[23].value=1;
					break;
				case 'S':case 's'://三层下行
					current[24].value=1;
					break;
				case 'A':case 'a'://二层下行
					current[25].value=1;
					break;
				default:
					break;
				}

			}
		}
	}//请求转换完毕

	return;
}
