class Piece:
    Empty, O, X = range(0, 3)


class Board:
    board = []

    win_states = [[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]

    def __init__(self, i):
        assert i <= 3**9
        self.board = []
        for _ in range(9):
            current = i % 3
            i //= 3
            # print(i, current)
            self.board.append(current)

    def validate(self):
        x = 0
        o = 0
        for i in self.board:
            x += (i == Piece.X)
            o += (i == Piece.O)

        if abs(x - o) > 1:
            return False

        return self.validate_winstate(Piece.X) + self.validate_winstate(Piece.O) < 2

    def validate_winstate(self, piece):
        board = self.board.copy()
        wins = 0
        for w in self.win_states:
            win = True
            for p in w:
                if board[p] != piece:
                    win = False
            if win:
                for p in w:
                    board[p] = 0
                wins += 1

        return wins

    def __str__(self):
        p = []
        for i\
                in self.board:
            p.append("X" if i == Piece.X else "O" if i == Piece.O else " ")
        return """
{} | {} | {}
---------
{} | {} | {}
---------
{} | {} | {}
""".format(*p)

s = 0
for i in range(3**9):
    b = Board(i)
    if b.validate():
        print(b)
        s += 1

print("Total: {}".format(s))
