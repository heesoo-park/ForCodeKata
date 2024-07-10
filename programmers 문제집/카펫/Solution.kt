// 내부 직사각형이 중심인 코드
class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        // 1부터 yellow까지 돌면서 몇줄짜리 내부 직사각형이 가능한지 체크
        return (1..yellow)
            // 순회하는 숫자로 나눠진다면 리스트에 저장(= 순회하는 숫자의 세로길이를 가지는 직사각형이 만들어짐)
            .filter { yellow % it == 0 }
            // 내부 직사각형 크기가 정해진 상태에서 테두리 개수가 brown과 같은지 비교
            // first로 하는 이유는 카펫의 가로 길이가 세로 길이와 같거나 길기 때문이다.
            .first { brown == (yellow / it * 2) + (it * 2) + 4 }
            // (내부 직사각형의 가로 + 2)가 카펫의 가로길이, (내부 직사각형의 세로 + 2)가 카펫의 세로길이
            .let { intArrayOf(yellow / it + 2, it + 2) }
    }
}

// 외부 테두리가 중심인 코드
class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var totalGrid = brown + yellow

        for (row in 3..totalGrid / 3) {
            if (totalGrid % row != 0) continue

            var temp = totalGrid / row * 2 + (row - 2) * 2
            if (temp == brown) {
                answer += totalGrid / row
                answer += row
                break
            }
        }
        
        return answer
    }
}
