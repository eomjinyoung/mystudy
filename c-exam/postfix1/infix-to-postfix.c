#include <stdio.h>
#include <string.h>

#define MAX_EXPR_SIZE 100
#define MAX_STACK_SIZE 100

typedef enum {
  lparen, rparen, plus, minus, times, divide, mod, eos, operand
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

int main() {
  scanf("%[^\n]s", expr);
  postfix();
  printf("\n");
  return 0;
}

void postfix() {
  char symbol;
  int n = 0;
  precedence token;
  stack[0] = eos; // 스택에서 값을 꺼낼 때 스택의 끝을 표시하기 위함

  for (token = getToken(&symbol, &n); token != eos; token = getToken(&symbol, &n)) {
    if (token == operand) {
      printf("%c", symbol);
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
  *symbol = expr[(*n)++];
  switch (*symbol) {
    case '(' : return lparen;
    case ')' : return rparen;
    case '+' : return plus;
    case '-' : return minus;
    case '/' : return divide;
    case '*' : return times;
    case '%' : return mod;
    case ' ' : return eos;
    case '\0' : return eos;
    default : return operand;
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
  switch (token) {
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
