# Lambda

### 정의
  - 이름 없는 익명 함수, 인자로 사용 가능한 함수
  - 순수 함수(반환 값이 매개 변수에 전적으로 의존)와는 개념과는 다름
  - 고차 함수(함수를 인자로 받거나 반환하는 함수)와도 개념이 다름
  - 람다식의 장점과 단점

### 장단점
  - 장점
    1. 코드를 간결하게 만들 수 있습니다.
    2. 코드가 간결하고 식에 개발자의 의도가 명확히 드러나므로 가독성이 향상됩니다.
    3. 코드량 줄어듬 => 코딩하는 시간 감소(과연?)
    4. 병렬프로그래밍이 용이
  - 단점
    1. 람다를 사용하면서 만드는 무명함수는 재사용이 불가능합니다.
    2. 디버깅이 다소 까다롭습니다.
    3. 람다를 남발하면 코드가 지저분해질 수 있습니다. (비슷한 함수를 계속 중복생성할 가능성이 높음)

### 문법
```
val sum = {x: Int, y: Int -> x + y}
```
```
private fun findMax(list: ArrayList<Int>) =
        list.maxBy({it})
private fun findMax(list: ArrayList<Int>) =
        list.maxBy{it}
```
```
// 모두 () 안에 표현하기
something({ /* Something function one */ }, { /* Something function two */ })

// 하나는 () 안에 표현하고, 하나는 () 밖에 표현하기
something({ /* Something function one */ }) { /* Something function two */ }
```

### it? (콜렉션 확장함수 사용 예시)
정석
```
private fun findMax(list: ArrayList<Int>) =
    list.maxBy { value: Int -> value } ?: 0
```
변수 타입 생략
```
private fun findMax(list: ArrayList<Int>) =
    list.maxBy { value -> value } ?: 0
```
인자가 1개 일때는 it으로 대체
```
private fun findMax(list: ArrayList<Int>) =
    list.maxBy { it } ?: 0
```

### Closure 변수 포획
클로저(Closure)는 outer scope(상위 함수의 영역)의 변수를 접근할 수 있는 함수를 말합니다. 
코틀린은 클로저를 지원하며 그렇기 때문에 익명함수는 함수 밖에서 정의된 변수에 접근할 수 있습니다.
```
fun add(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x + y
    }
}

fun main(args: Array<String>) {
    val func = add(10)
    val result = func(20)
    println(result)
}
```
또 다른 예시
```
var sum = 0
ints.filter { it > 0 }.forEach {
    sum += it
}
print(sum)
```

출처: https://codechacha.com/ko/kotlin-closures/

### 컬렉션 확장 함수
1. map - 연산하기
2. filter - 걸러내기
3. all - 모든 원소가 만족하는지
4. any - 하나라도 있는지 
5. count, find
6. groupBy - 자동 그룹핑
7. flatmap, flatten
flatMap은 주어진 람다를 컬렉션의 모든 객체에 적용하고, 적용한 결과로 얻어지는 여러 리스트를 한 리스트로 flat 하게 만드는 함수입니다.
flatten은 arrayOfarray에서 반환값(람다식)이 없는 경우 사용
```
fun main(args: Array) { 
    val strings = listOf("abc", "def") 
    println(strings.flatMap { it.toList() }) 
}
Map
 key: 0 = [a,b,c]
 key: 1 = [e, f, g]
result: [a, b, c, e, f, g]
```

### Sequence (lazy collection)
중간 단계에서 생성되는 temp collection 활용 x 
 - asSequence 만 넣어주면된다. 개꿀딱 
 - 최종 연산시에 연산이 이루어짐
 - 원소를 하나씩 처리하기 떄문에 filter/map 활용을 잘하자
 
### Sam (Single abstract method)
 - SAM(Single Abstract Method)은 interface에 1개의 abstract methods만 있을 경우
```
public interface OnClickListener {
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    void onClick(View v);
}

public void setOnClickListener(@Nullable OnClickListener l) {
    if (!isClickable()) {
        setClickable(true);
    }
    getListenerInfo().mOnClickListener = l;
}
```
This is what SAM dose!
```
fab.setOnClickListener { /* Something */ }
```

### with & apply
 - this를 쓰자
 - with는 return을 apply는 no return을
 - apply는 생성 및 세팅 할 때 사용하기 좋습니다. (e.g. TextView)
