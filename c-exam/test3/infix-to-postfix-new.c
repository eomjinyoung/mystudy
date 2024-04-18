// 01. 수식 입력 받고 출력하기
// 02. tokenize 해서 출력하기
// 03. getToken() 구현: 토큰을 eos(0), 연산자(1), 피연산자(2)로 구분하기
// 04. eos 일 때 stack에 있는 연산자 모두 pop
// 05. token 구분하기: token 종류를 상세하게 구분, enum 정의
// 06. push(), pop(), printToken() 구현
// 07. 연산자 추가: &&, ||, <<, >>, <=, !=, ==, <, >, >=
// 08. 연산자 우선순위 적용
// 09. 연산자를 문자열로 배열에 저장해서 다루기

#include <stdio.h>
#include <string.h>

#define MAX_EXPR_SIZE 100
#define MAX_STACK_SIZE 100
#define MAX_TOKEN_TITLE_LENGTH 10

typedef enum {
  lparen, rparen, plus, minus, times, divide, mod, eos, operand
  , logical_and, logical_or, left_shift, right_shift
  , less_equal, not_equal, equal, less, greater, greater_equal
} precedence;

void postfix_new(); 
precedence getToken(char *, int *);
void push(precedence);
precedence pop();
void printToken(precedence);

char expr[MAX_EXPR_SIZE]; /* input string */
precedence stack[MAX_STACK_SIZE];

static int isp[] = {0, 19, 12, 12, 13, 13, 13, 0, 0
  , 5, 4, 11, 11
  , 10, 9, 9, 10, 10, 10
};
static int icp[] = {20, 19, 12, 12, 13, 13, 13, 0, 0
  , 5, 4, 11, 11
  , 10, 9, 9, 10, 10, 10
};
const char token_titles[][MAX_TOKEN_TITLE_LENGTH] = {
  "(", ")", "+", "-", "*", "/", "%", "", ""
  , "&&", "||", "<<", ">>"
  , "<=", "!=", "==", "<", ">", ">="
};

int top = -1;

int main() {
  scanf("%[^\n]s", expr);
  postfix_new();
  printf("\n");
  return 0;
}

void postfix_new() {
  char symbol[5];
  int n = 0;
  precedence token;
  
  push(eos);
  
  for (token = getToken(symbol, &n); token != eos; token = getToken(symbol, &n)) {
    if (token == operand) {
      printf("%s", symbol);
    } else if (token == rparen) {
      while (stack[top] != lparen) {
        printToken(pop());
      }
      pop(); // lparen 버림
    } else {
      while (isp[stack[top]] >= icp[token]) {
        printToken(pop());
      }
      push(token);
    }
  }
  // eos
  while ((token = pop()) != eos) {
    printToken(token);
  }
}

precedence getToken(char *symbol, int *n) {
  // 표현식에 공백이 들어가기 때문에 문자를 읽을 임시 변수가 필요함
  char ch;
  int str_len = 0;
  while ((ch = expr[(*n)++]) != 0 && ch != ' ') { // ch는 공백이나 null 이면 반복문 나감.
    symbol[str_len++] = ch;
  }
  symbol[str_len] = 0;

  // 읽은 토큰이 없으면 표현식의 끝으로 간주한다.
  if (str_len == 0) {
    return eos;
  } 

  int tokenCount = sizeof(token_titles) / MAX_TOKEN_TITLE_LENGTH;

  for (int i = 0; i < tokenCount; i++) {
    if (strcmp(symbol, token_titles[i]) == 0) {
      return i;
    }
  }

  // 표현식의 끝에 도달했다면 읽기 위치를 뒤로 한 칸 이동시킨다.
  if (ch == eos) {
    (*n)--;
  }
  return operand;
}

void push(precedence token)
{
  stack[++top] = token;
}

precedence pop()
{
  return stack[top--];
}

void printToken(precedence token) 
{
  printf("%s", token_titles[token]);
}

