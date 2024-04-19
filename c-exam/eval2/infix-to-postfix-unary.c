#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_EXPR_SIZE 100
#define MAX_STACK_SIZE 100

typedef enum
{
  lparen,
  rparen,
  plus,
  minus,
  times,
  divide,
  mod,
  eos,
  operand
} precedence;

void postfix();
precedence getToken(char *, int *);
void push(precedence);
precedence pop();
void printToken(precedence);

char expr[MAX_EXPR_SIZE]; /* input string */
precedence stack[MAX_STACK_SIZE];

static int isp[] = {0, 19, 12, 12, 13, 13, 13, 0};
static int icp[] = {20, 19, 12, 12, 13, 13, 13, 0};

int top = 0;

int main()
{
  scanf("%[^\n]s", expr);
  postfix();
  printf("\n");
  return 0;
}

void postfix()
{
  char symbol;
  int n = 0;
  precedence token;
  stack[0] = eos;                 // 스택에서 값을 꺼낼 때 스택의 끝을 표시하기 위함
  precedence previousToken = eos; // 이전에 읽은 토큰
  int isUnaryOperator = false;

  for (token = getToken(&symbol, &n); token != eos; token = getToken(&symbol, &n))
  {
    if (token == operand)
    {
      printf("%c", symbol);
      if (isUnaryOperator)
      {
        printToken(pop()); // 연산자를 꺼낸다.
        pop();             // lparan 을 제거한다.
        isUnaryOperator = false;
      }
    }
    else if (token == rparen)
    {
      while (stack[top] != lparen)
      {
        printToken(pop());
      }
      pop(); // lparen 버림
    }
    else
    {
      if ((token == plus || token == minus) && previousToken != operand)
      {
        // 이전에 읽은 토큰이 피연산자가 아닐 경우, 단항연산자로 다룬다.
        push(lparen);
        printf("0");
        isUnaryOperator = true;
      }
      else
      {
        // 이항 연산자일 경우
        while (isp[stack[top]] >= icp[token])
        {
          printToken(pop());
        }
      }
      push(token);
    }
    previousToken = token;
  }
  // eos
  while ((token = pop()) != eos)
  {
    printToken(token);
  }
}

precedence getToken(char *symbol, int *n)
{
  *symbol = expr[(*n)++];
  switch (*symbol)
  {
  case '(':
    return lparen;
  case ')':
    return rparen;
  case '+':
    return plus;
  case '-':
    return minus;
  case '/':
    return divide;
  case '*':
    return times;
  case '%':
    return mod;
  case ' ':
    return eos;
  case '\0':
    return eos;
  default:
    return operand;
  }
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
  switch (token)
  {
  case plus:
    printf("+");
    break;
  case minus:
    printf("-");
    break;
  case times:
    printf("*");
    break;
  case divide:
    printf("/");
    break;
  case mod:
    printf("%%");
    break;
  default:
    break;
  }
}
