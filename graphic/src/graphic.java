import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class graphic {
	public static void main(String[] args) {
		Puzzle f = new Puzzle("Image Puzzle");
	}
}

class Puzzle implements ActionListener {
	JFrame f;
	ImageIcon m1;
	JLabel l1 = new JLabel(m1);
	JButton[][] b1;
	Image[] image;
	Panel p = new Panel();
	int i, j, size = 0, temp;
	int c1, c2, ch1, ch2;
	int[] check;
	int height = 0, width = 0;
	Set hs = new LinkedHashSet();
	Iterator it;

	Puzzle(String name) {
		randPhoto();
		f = new JFrame(name);
		f.setSize(width + 150, height + 150);
		name = JOptionPane.showInputDialog("원하시는 필드의 크기를 입력해주세요.");
		size = Integer.parseInt(name);
		flow();
	}

	void flow() {
		fset();
		hsSet();
		makeMap();
	}

	void randPhoto() {
		int rand;
		String temp = null;
		rand = (int) (Math.random() * 3);
		switch (rand) {
		case 0:
			temp = "a" + ".jpg";
			break;
		case 1:
			temp = "b" + ".jpg";
			break;
		case 2:
			temp = "c" + ".jpg";
			break;
		}
		m1 = new ImageIcon(temp);
		height = m1.getIconHeight();
		width = m1.getIconWidth();
	}

	void fset() {
		p.setSize(height, width);
		p.setLayout(new GridLayout(size, size));
		f.add(p, "West");
		f.setVisible(true);
	}

	void hsSet() {
		while (hs.size() < (size * size)) {
			temp = (int) (Math.random() * (size * size));
			hs.add(temp);
		}
		it = hs.iterator();
	}

	void makeMap() {
		int x = 0, y = 0, temp = 0;
		check = new int[size * size];
		image = new Image[size * size];
		b1 = new JButton[size][size];

		i = width / size;
		j = height / size;
		while (temp < size * size) {
			Image im = m1.getImage();
			im = f.createImage(new FilteredImageSource(im.getSource(), new CropImageFilter(x, y, i, j)));
			image[temp] = im;
			x += j;
			temp++;
			if (temp % size == 0) {
				y += i;
				x = 0;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
